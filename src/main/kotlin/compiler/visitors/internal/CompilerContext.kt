package org.example.compiler.visitors.internal

interface CompilerContext {
    val continuationBuffer : ArrayDeque<String>
    var funCallCounter : Int

    var bufferCleaner : () -> Unit
}

class CompilerContextImpl : CompilerContext {
    override val continuationBuffer = ArrayDeque<String>()
    override var funCallCounter = 0
    override var bufferCleaner: () -> Unit = {}
}