package org.example.compiler

import MiniKotlinBaseVisitor
import MiniKotlinParser
import org.example.compiler.visitors.internal.CompilerContext
import org.example.compiler.visitors.internal.CompilerContextImpl
import org.example.compiler.visitors.DeclarationVisitor
import org.example.compiler.visitors.ExpressionVisitor
import org.example.compiler.visitors.ProgramVisitor
import org.example.compiler.visitors.StatementVisitor

class MiniKotlinCompiler : MiniKotlinBaseVisitor<String>(),
    ExpressionVisitor,
    DeclarationVisitor,
    ProgramVisitor,
    StatementVisitor,
    CompilerContext by CompilerContextImpl()
{
    fun compile(program: MiniKotlinParser.ProgramContext, className: String = "MiniProgram"): String {
        val programOutput = visit(program)

        return """
            public class $className {
                $programOutput
            }
        """.trimIndent()
    }

    // The following methods are just specified where methods of Visitor were overridden

    //--------------------
    //      Visitors
    //--------------------

    override fun visitProgram(ctx: MiniKotlinParser.ProgramContext): String {
        return super<ProgramVisitor>.visitProgram(ctx)
    }

    //--------------------
    //      Declarations
    //--------------------

    override fun visitFunctionDeclaration(ctx: MiniKotlinParser.FunctionDeclarationContext): String {
        return super<DeclarationVisitor>.visitFunctionDeclaration(ctx)
    }

    override fun visitParameterList(ctx: MiniKotlinParser.ParameterListContext): String {
        return super<DeclarationVisitor>.visitParameterList(ctx)
    }

    override fun visitParameter(ctx: MiniKotlinParser.ParameterContext): String {
        return super<DeclarationVisitor>.visitParameter(ctx)
    }

    override fun visitVariableDeclaration(ctx: MiniKotlinParser.VariableDeclarationContext): String {
        return super<DeclarationVisitor>.visitVariableDeclaration(ctx)
    }

    override fun visitType(ctx: MiniKotlinParser.TypeContext): String {
        return super<DeclarationVisitor>.visitType(ctx)
    }

    //--------------------
    //      Statements
    //--------------------

    override fun visitBlock(ctx: MiniKotlinParser.BlockContext): String {
        return super<StatementVisitor>.visitBlock(ctx)
    }

    override fun visitIfStatement(ctx: MiniKotlinParser.IfStatementContext): String {
        return super<StatementVisitor>.visitIfStatement(ctx)
    }

    override fun visitWhileStatement(ctx: MiniKotlinParser.WhileStatementContext): String {
        return super<StatementVisitor>.visitWhileStatement(ctx)
    }

    override fun visitVariableAssignment(ctx: MiniKotlinParser.VariableAssignmentContext): String {
        return super<StatementVisitor>.visitVariableAssignment(ctx)
    }

    override fun visitReturnStatement(ctx: MiniKotlinParser.ReturnStatementContext): String {
        return super<StatementVisitor>.visitReturnStatement(ctx)
    }

    //--------------------
    //      Expressions
    //--------------------

    override fun visitMulDivExpr(ctx: MiniKotlinParser.MulDivExprContext): String {
        return super<ExpressionVisitor>.visitMulDivExpr(ctx)
    }

    override fun visitAddSubExpr(ctx: MiniKotlinParser.AddSubExprContext): String {
        return super<ExpressionVisitor>.visitAddSubExpr(ctx)
    }

    override fun visitNotExpr(ctx: MiniKotlinParser.NotExprContext): String {
        return super<ExpressionVisitor>.visitNotExpr(ctx)
    }

    override fun visitAndExpr(ctx: MiniKotlinParser.AndExprContext): String {
        return super<ExpressionVisitor>.visitAndExpr(ctx)
    }

    override fun visitOrExpr(ctx: MiniKotlinParser.OrExprContext): String {
        return super<ExpressionVisitor>.visitOrExpr(ctx)
    }

    override fun visitComparisonExpr(ctx: MiniKotlinParser.ComparisonExprContext): String {
        return super<ExpressionVisitor>.visitComparisonExpr(ctx)
    }

    override fun visitEqualityExpr(ctx: MiniKotlinParser.EqualityExprContext): String {
        return super<ExpressionVisitor>.visitEqualityExpr(ctx)
    }

    override fun visitFunctionCallExpr(ctx: MiniKotlinParser.FunctionCallExprContext): String {
        return super<ExpressionVisitor>.visitFunctionCallExpr(ctx)
    }

    override fun visitArgumentList(ctx: MiniKotlinParser.ArgumentListContext): String {
        return super<ExpressionVisitor>.visitArgumentList(ctx)
    }

    override fun visitIdentifierExpr(ctx: MiniKotlinParser.IdentifierExprContext): String {
        return super<ExpressionVisitor>.visitIdentifierExpr(ctx)
    }

    override fun visitParenExpr(ctx: MiniKotlinParser.ParenExprContext) : String {
        return super<ExpressionVisitor>.visitParenExpr(ctx)
    }

    override fun visitIntLiteral(ctx: MiniKotlinParser.IntLiteralContext): String {
        return super<ExpressionVisitor>.visitIntLiteral(ctx)
    }

    override fun visitStringLiteral(ctx: MiniKotlinParser.StringLiteralContext): String {
        return super<ExpressionVisitor>.visitStringLiteral(ctx)
    }

    override fun visitBoolLiteral(ctx: MiniKotlinParser.BoolLiteralContext): String {
        return super<ExpressionVisitor>.visitBoolLiteral(ctx)
    }

}
