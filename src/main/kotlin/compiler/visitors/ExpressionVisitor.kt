package org.example.compiler.visitors

import MiniKotlinVisitor
import org.example.compiler.visitors.expression.BaseArithmeticVisitor
import org.example.compiler.visitors.expression.BaseCallVisitor
import org.example.compiler.visitors.expression.BaseLiteralVisitor
import org.example.compiler.visitors.expression.BaseLogicalVisitor

interface ExpressionVisitor :
    BaseArithmeticVisitor,
    BaseLogicalVisitor,
    BaseCallVisitor,            // Function calls and data extraction
    BaseLiteralVisitor
