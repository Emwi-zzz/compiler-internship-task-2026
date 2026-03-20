package org.example.compiler.visitors.expression

import MiniKotlinParser
import MiniKotlinVisitor

interface BaseLiteralVisitor : MiniKotlinVisitor<String> {

    override fun visitParenExpr(ctx: MiniKotlinParser.ParenExprContext): String {
        val expr = visit(ctx.expression())
        return "( $expr )"
    }
    override fun visitIntLiteral(ctx: MiniKotlinParser.IntLiteralContext): String {
        return ctx.text
    }

    override fun visitStringLiteral(ctx: MiniKotlinParser.StringLiteralContext): String {
        return ctx.text
    }

    override fun visitBoolLiteral(ctx: MiniKotlinParser.BoolLiteralContext): String {
        return ctx.text
    }

}