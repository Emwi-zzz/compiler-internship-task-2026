package org.example.compiler.visitors

import MiniKotlinVisitor

interface ProgramVisitor : MiniKotlinVisitor<String> {

    override fun visitProgram(ctx: MiniKotlinParser.ProgramContext): String {
        TODO("Not yet implemented")
    }

}