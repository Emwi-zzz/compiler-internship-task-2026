package org.example.compiler.visitors

import MiniKotlinVisitor

interface StatementVisitor : MiniKotlinVisitor<String> {
    override fun visitBlock(ctx: MiniKotlinParser.BlockContext): String {
        TODO("Not yet implemented")
    }

    override fun visitIfStatement(ctx: MiniKotlinParser.IfStatementContext): String {
        TODO("Not yet implemented")
    }

    override fun visitWhileStatement(ctx: MiniKotlinParser.WhileStatementContext): String {
        TODO("Not yet implemented")
    }

    override fun visitVariableAssignment(ctx: MiniKotlinParser.VariableAssignmentContext): String {
        TODO("Not yet implemented")
    }

    override fun visitReturnStatement(ctx: MiniKotlinParser.ReturnStatementContext): String {
        TODO("Not yet implemented")
    }

}