package org.example.compiler.visitors.expression

import MiniKotlinVisitor

interface BaseLiteralVisitor : MiniKotlinVisitor<String> {

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