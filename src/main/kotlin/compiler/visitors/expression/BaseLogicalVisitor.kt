package org.example.compiler.visitors.expression

import MiniKotlinVisitor

interface BaseLogicalVisitor : MiniKotlinVisitor<String>{

    override fun visitNotExpr(ctx: MiniKotlinParser.NotExprContext): String {
        return "!" + visit(ctx.expression())
    }

    override fun visitAndExpr(ctx: MiniKotlinParser.AndExprContext): String {
        val left = visit(ctx.expression(0))
        val right = visit(ctx.expression(1))
        return "$left && $right"
    }

    override fun visitOrExpr(ctx: MiniKotlinParser.OrExprContext): String {
        val left = visit(ctx.expression(0))
        val right = visit(ctx.expression(1))
        return "$left || $right"
    }

    override fun visitComparisonExpr(ctx: MiniKotlinParser.ComparisonExprContext): String {
        val left = visit(ctx.expression(0))
        val right = visit(ctx.expression(1))
        val exp = when {
            ctx.LT() != null -> "<"
            ctx.GT() != null -> ">"
            ctx.GE() != null -> ">="
            ctx.LE() != null -> "<="
            else -> throw IllegalStateException("Unknown operator")
        }
        return "$left $exp $right"
    }

    override fun visitEqualityExpr(ctx: MiniKotlinParser.EqualityExprContext): String {
        val left = visit(ctx.expression(0))
        val right = visit(ctx.expression(1))
        val exp = when {
            ctx.EQ() != null -> "=="
            ctx.NEQ() != null -> "!="
            else -> throw IllegalStateException("Unknown operator")
        }
        return "$left $exp $right"
    }

}