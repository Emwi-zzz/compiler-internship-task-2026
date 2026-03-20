package org.example.compiler.visitors

import MiniKotlinVisitor
import org.example.compiler.visitors.internal.CompilerContext

interface ProgramVisitor : MiniKotlinVisitor<String>, CompilerContext {

    override fun visitProgram(ctx: MiniKotlinParser.ProgramContext): String {
        val program = StringBuilder()
        ctx.functionDeclaration().forEach {
            program.append(visit(it))
            program.append("\n\n")
        }
        return program.toString()
    }

}