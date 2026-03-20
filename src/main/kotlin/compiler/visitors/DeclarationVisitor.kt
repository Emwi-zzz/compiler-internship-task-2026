package org.example.compiler.visitors

import MiniKotlinVisitor

interface DeclarationVisitor : MiniKotlinVisitor<String> {

    override fun visitFunctionDeclaration(ctx: MiniKotlinParser.FunctionDeclarationContext): String {
        val functionDeclaration = StringBuilder("public static void ")
        val reassignment = StringBuilder()
        val name = ctx.IDENTIFIER().text

        functionDeclaration.append("$name(")

        if (name == "main") {
            functionDeclaration.append("String[] args")
        } else{
            if (ctx.parameterList() != null) {
                functionDeclaration.append(visit(ctx.parameterList()))

                ctx.parameterList().parameter().forEach {
                    val ident = it.IDENTIFIER().text

                    val type = visit(it.type())
                    reassignment.append("$type[] $ident = new $type[]{ __function_parameter_$ident };\n")
                }
            }
            val continuationType = visit(ctx.type())
            functionDeclaration.append("Continuation<$continuationType> __continuation")
        }
        functionDeclaration.append(") {\n")
        functionDeclaration.append(reassignment)
        val block = visit(ctx.block()).drop(1)



        functionDeclaration.append(block)

        return functionDeclaration.toString()
    }

    override fun visitParameterList(ctx: MiniKotlinParser.ParameterListContext): String {
        val parametersList = StringBuilder()

        ctx.parameter().forEach {
            parametersList.append(visit(it))
            parametersList.append(", ")
        }

        return parametersList.toString()
    }

    override fun visitParameter(ctx: MiniKotlinParser.ParameterContext): String {

        val type = visit(ctx.type())

        val ident = ctx.IDENTIFIER().text
        return "$type __function_parameter_$ident"
    }

    override fun visitVariableDeclaration(ctx: MiniKotlinParser.VariableDeclarationContext): String {
        val type = visit(ctx.type())

        val ident = ctx.IDENTIFIER().text

        val expr = visit(ctx.expression())

        return "$type[] $ident = new $type[]{ $expr }"

    }

    override fun visitType(ctx: MiniKotlinParser.TypeContext): String {
        return when (ctx.text) {
            "Int" -> "Integer"
            "String" -> "String"
            "Boolean" -> "Boolean"
            "Unit" -> "Void"
            else -> throw Exception("Unknown type: ${ctx.text}")
        }
    }

}