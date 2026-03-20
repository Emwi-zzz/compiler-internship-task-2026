package org.example.compiler.visitors.expression

import MiniKotlinVisitor

interface BaseArithmeticVisitor : MiniKotlinVisitor<String> {

    override fun visitMulDivExpr(ctx: MiniKotlinParser.MulDivExprContext): String {
        val left = visit(ctx.expression(0))
        val right = visit(ctx.expression(1))

        val op = when {
            ctx.MULT() != null -> "*"
            ctx.DIV() != null  -> "/"
            ctx.MOD() != null  -> "%"
            else -> throw IllegalStateException("Unknown operator")
        }

        return "$left $op $right"
    }

    override fun visitAddSubExpr(ctx: MiniKotlinParser.AddSubExprContext): String {
        val left = visit(ctx.expression(0))
        val right = visit(ctx.expression(1))

        val op = when {
            ctx.PLUS() != null -> "+"
            ctx.MINUS() != null  -> "-"
            else -> throw IllegalStateException("Unknown operator")
        }

        return "$left $op $right"
    }

}