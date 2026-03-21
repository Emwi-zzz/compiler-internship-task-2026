package org.example.compiler.visitors.expression

import MiniKotlinVisitor
import org.example.compiler.visitors.internal.CompilerContext

interface BaseCallVisitor : MiniKotlinVisitor<String>, CompilerContext {

    fun generateResultName() : String{
        return "__result$funCallCounter"
    }
    override fun visitFunctionCallExpr(ctx: MiniKotlinParser.FunctionCallExprContext): String {
        val functionCall = StringBuilder()
        var name = ctx.IDENTIFIER().text
        if(name == "println") name = "Prelude.println"
        functionCall.append(name)
        functionCall.append("(")
        if(ctx.argumentList() != null) {
            functionCall.append(visit(ctx.argumentList()))
        }
        val resultName = generateResultName()

        functionCall.append("($resultName) -> {\n")

        continuationBuffer.add(functionCall.toString())

        funCallCounter++

        return when(ctx.parent){
            is MiniKotlinParser.StatementContext -> ""
            else -> resultName
        }
    }

    override fun visitIdentifierExpr(ctx: MiniKotlinParser.IdentifierExprContext) : String {
        val name = ctx.IDENTIFIER().text
        return "$name[0]"
    }

    override fun visitArgumentList(ctx: MiniKotlinParser.ArgumentListContext): String {
        val argumentList = StringBuilder()

        ctx.expression().forEach {
            argumentList.append(visit(it))
            argumentList.append(", ")
        }

        return argumentList.toString()
    }

}