package org.example.compiler

import MiniKotlinLexer
import MiniKotlinParser
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.io.TempDir
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.test.assertIs
import kotlin.test.assertTrue

class MiniKotlinCompilerTest {

    @TempDir
    lateinit var tempDir: Path

    private fun parseString(source: String): MiniKotlinParser.ProgramContext {
        val input = CharStreams.fromString(source)
        val lexer = MiniKotlinLexer(input)
        val tokens = CommonTokenStream(lexer)
        val parser = MiniKotlinParser(tokens)
        return parser.program()
    }

    private fun parseFile(path: Path): MiniKotlinParser.ProgramContext {
        val input = CharStreams.fromPath(path)
        val lexer = MiniKotlinLexer(input)
        val tokens = CommonTokenStream(lexer)
        val parser = MiniKotlinParser(tokens)
        return parser.program()
    }

    private fun resolveStdlibPath(): Path? {
        val devPath = Paths.get("build", "stdlib")
        if (devPath.toFile().exists()) {
            val stdlibJar = devPath.toFile().listFiles()
                ?.firstOrNull { it.name.startsWith("stdlib") && it.name.endsWith(".jar") }
            if (stdlibJar != null) return stdlibJar.toPath()
        }
        return null
    }

    private fun getOutput(source: String): String {

        val examplePath = Paths.get(source)
        val program = parseFile(examplePath)

        val compiler = MiniKotlinCompiler()
        val javaCode = compiler.compile(program)

        val javaFile = tempDir.resolve("MiniProgram.java")
        Files.writeString(javaFile, javaCode)

        val javaCompiler = JavaRuntimeCompiler()
        val stdlibPath = resolveStdlibPath()
        val (compilationResult, executionResult) = javaCompiler.compileAndExecute(javaFile, stdlibPath)

        assertIs<CompilationResult.Success>(compilationResult)
        assertIs<ExecutionResult.Success>(executionResult)

        return executionResult.stdout
    }

    @Test
    fun `compile example_mini outputs 120 and 15`() {
        val output = getOutput("samples/example.mini")
        assertTrue(output.contains("120"), "Expected output to contain factorial result 120, but got: $output")
        assertTrue(output.contains("15"), "Expected output to contain arithmetic result 15, but got: $output")
    }

    @Test
    fun `compile test1`() {
        val output = getOutput("samples/tests/test1.kt")

        assertTrue(output.contains("11"), "Expected output to contain factorial result 120, but got: $output")
        assertTrue(output.contains("high_value"), "Expected output to contain arithmetic result 15, but got: $output")

        assertTrue(output.contains("true"), "Expected output to contain factorial result true, but got: $output")
        assertTrue(output.contains("1024"), "Expected output to contain arithmetic result 15, but got: $output")
    }

    @Test
    fun `compile test2`() {
        val output = getOutput("samples/tests/test2.kt")

        assertTrue(output.contains("6"), "Expected output to contain 6, but got: $output")
        assertTrue(output.contains("25"), "Expected output to contain 25, but got: $output")

        assertTrue(output.contains("36"), "Expected output to contain 36, but got: $output")

        }
}
