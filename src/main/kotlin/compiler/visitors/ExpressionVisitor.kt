package org.example.compiler.visitors

import MiniKotlinVisitor

interface ExpressionVisitor : MiniKotlinVisitor<String> {

    // Math

    override fun visitMulDivExpr(ctx: MiniKotlinParser.MulDivExprContext): String {
        TODO("Not yet implemented")
    }

    override fun visitAddSubExpr(ctx: MiniKotlinParser.AddSubExprContext): String {
        TODO("Not yet implemented")
    }

    // Logic

    override fun visitNotExpr(ctx: MiniKotlinParser.NotExprContext): String {
        TODO("Not yet implemented")
    }

    override fun visitAndExpr(ctx: MiniKotlinParser.AndExprContext): String {
        TODO("Not yet implemented")
    }

    override fun visitOrExpr(ctx: MiniKotlinParser.OrExprContext): String {
        TODO("Not yet implemented")
    }

    override fun visitComparisonExpr(ctx: MiniKotlinParser.ComparisonExprContext): String {
        TODO("Not yet implemented")
    }

    override fun visitEqualityExpr(ctx: MiniKotlinParser.EqualityExprContext): String {
        TODO("Not yet implemented")
    }

    //  Calls and Data access

    override fun visitFunctionCallExpr(ctx: MiniKotlinParser.FunctionCallExprContext): String {
        TODO("Not yet implemented")
    }

    override fun visitIdentifierExpr(ctx: MiniKotlinParser.IdentifierExprContext) : String {
        TODO("Not yet implemented")
    }

    // Literals

    override fun visitIntLiteral(ctx: MiniKotlinParser.IntLiteralContext): String {
        TODO("Not yet implemented")
    }

    override fun visitStringLiteral(ctx: MiniKotlinParser.StringLiteralContext): String {
        TODO("Not yet implemented")
    }

    override fun visitBoolLiteral(ctx: MiniKotlinParser.BoolLiteralContext): String {
        TODO("Not yet implemented")
    }
}