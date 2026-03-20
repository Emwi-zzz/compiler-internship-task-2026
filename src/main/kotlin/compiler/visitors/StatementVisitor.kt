package org.example.compiler.visitors

import MiniKotlinVisitor
import org.example.compiler.visitors.internal.CompilerContext

interface StatementVisitor : MiniKotlinVisitor<String>, CompilerContext {


    override fun visitBlock(ctx: MiniKotlinParser.BlockContext): String {
        funCallCounter.add(0)

        val block = StringBuilder()
        block.append("{\n")
        ctx.statement().forEach {
            val visited = visit(it)
            while (continuationBuffer.isNotEmpty()) {
                block.append(continuationBuffer.removeLast())
            }
            block.append(visited)
            block.append(";\n")
        }
        block.append("\n});".repeat(funCallCounter.removeLast()))

        block.append("\n}\n")
        return block.toString()
    }

    override fun visitIfStatement(ctx: MiniKotlinParser.IfStatementContext): String {
        val ifStatement = StringBuilder("if(")
        ifStatement.append(visit(ctx.expression()))
        ifStatement.append(")\n")
        ifStatement.append(visit(ctx.block(0)))

        if (ctx.block(1) != null) {
            ifStatement.append(" else ")
            ifStatement.append(visit(ctx.block(1)))
        }
        return ifStatement.toString()
    }

    override fun visitWhileStatement(ctx: MiniKotlinParser.WhileStatementContext): String {
        val whileStatement = StringBuilder("while(")
        whileStatement.append(visit(ctx.expression()))
        whileStatement.append(") ")
        whileStatement.append(visit(ctx.block()))
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