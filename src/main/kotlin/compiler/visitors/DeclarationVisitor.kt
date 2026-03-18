package org.example.compiler.visitors

import MiniKotlinVisitor

interface DeclarationVisitor : MiniKotlinVisitor<String> {

    override fun visitFunctionDeclaration(ctx: MiniKotlinParser.FunctionDeclarationContext): String {
        TODO("Not yet implemented")
    }

    override fun visitParameterList(ctx: MiniKotlinParser.ParameterListContext): String {
        TODO("Not yet implemented")
    }

    override fun visitParameter(ctx: MiniKotlinParser.ParameterContext): String {
        TODO("Not yet implemented")
    }

    override fun visitVariableDeclaration(ctx: MiniKotlinParser.VariableDeclarationContext): String {
        TODO("Not yet implemented")
    }

    override fun visitType(ctx: MiniKotlinParser.TypeContext): String {
        TODO("Not yet implemented")
    }

}