package org.example.compiler.visitors

import MiniKotlinVisitor
import org.example.compiler.visitors.internal.CompilerContext

interface StatementVisitor : MiniKotlinVisitor<String>, CompilerContext {

    override fun visitBlock(ctx: MiniKotlinParser.BlockContext): String {
        var closingCounter = 0
        val blockStart = continuationBuffer.size
        val block = StringBuilder("{")

        bufferCleaner =
            { while(continuationBuffer.isNotEmpty()){ block.append(continuationBuffer.removeFirst())
            closingCounter++
            }
            }
        ctx.statement().forEach {
            val statement = visit(it)
            bufferCleaner()
            block.append(statement)
            block.append(";\n")
        }

        block.append("});\n".repeat(closingCounter))
        block.append("}\n")
        return block.toString()
    }

    override fun visitIfStatement(ctx: MiniKotlinParser.IfStatementContext): String {
        val ifStatement = StringBuilder("if (")

        val expr = visit(ctx.expression())

        ifStatement.append(expr)
        ifStatement.append("){\n")

        bufferCleaner()

        ifStatement.append(visit(ctx.block(0)))
        ifStatement.append("}\n")

        if(ctx.block(1) != null) {
            ifStatement.append("else{\n")
            ifStatement.append(visit(ctx.block(1)))
            ifStatement.append("}\n")
        }

        return ifStatement.toString()
    }

    override fun visitWhileStatement(ctx: MiniKotlinParser.WhileStatementContext): String {
        val whileStatement = StringBuilder("while (")

        val expr = visit(ctx.expression())

        whileStatement.append(expr)
        whileStatement.append("){\n")

        bufferCleaner()

        whileStatement.append(visit(ctx.block()))
        whileStatement.append("}\n")

        return whileStatement.toString()
    }

    override fun visitVariableAssignment(ctx: MiniKotlinParser.VariableAssignmentContext): String {
        val varAssignment = StringBuilder()

        val name = ctx.IDENTIFIER().text

        varAssignment.append("$name[0]")
        varAssignment.append(" = ")
        varAssignment.append(visit(ctx.expression()))
        varAssignment.append(";\n")
        return varAssignment.toString()
    }

    override fun visitReturnStatement(ctx: MiniKotlinParser.ReturnStatementContext): String {
        val returnStatement = StringBuilder("__continuation.accept(")
        returnStatement.append(visit(ctx.expression()))
        returnStatement.append(");\n")
        returnStatement.append("return")
        return returnStatement.toString()
    }

}