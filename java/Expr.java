package com.craftinginterpreters.lox;

import java.util.List
abstract class Expr {
    interface Visitor<R> {
        R visitBinaryExpr(Binary expr);
        R visitGroupingExpr(Grouping expr);
        R visitLiteralExpr(Literal expr);
        R visitUnaryExpr(Unary expr);
    }
    static class Binaryextends Expr {
        Binary(Expr left, Token operator, Expr right) {
            this.left = left
            this.operator = operator
            this.right = right
        }

         @Override
         <R> R accept(Visitor<R> visitor) {
             return visitor.visitBinaryExpr(this);
         }

        final Expr left;
        final Token operator;
        final Expr right;
    }
    static class Groupingextends Expr {
        Grouping(Expr expression) {
            this.expression = expression
        }

         @Override
         <R> R accept(Visitor<R> visitor) {
             return visitor.visitGroupingExpr(this);
         }

        final Expr expression;
    }
    static class Literalextends Expr {
        Literal(Object value) {
            this.value = value
        }

         @Override
         <R> R accept(Visitor<R> visitor) {
             return visitor.visitLiteralExpr(this);
         }

        final Object value;
    }
    static class Unaryextends Expr {
        Unary(Token operator, Expr right) {
            this.operator = operator
            this.right = right
        }

         @Override
         <R> R accept(Visitor<R> visitor) {
             return visitor.visitUnaryExpr(this);
         }

        final Token operator;
        final Expr right;
    }

    abstract <R> R accept(Visitor<R> visitor);
}
