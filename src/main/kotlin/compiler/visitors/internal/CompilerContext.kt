package org.example.compiler.visitors.internal

interface CompilerContext {
    val continuationBuffer : ArrayDeque<String>
    var funCallCounter : ArrayDeque<Int>
}

class CompilerContextImpl : CompilerContext {
    override val continuationBuffer = ArrayDeque<String>()
    override var funCallCounter = ArrayDeque<Int>()
}