package org.grim3lt.util

import java.math.BigInteger

// SEE: http://www.isthe.com/chongo/tech/comp/fnv/index.html
object FNV {
    private val PRIME64 = "1099511628211".toBigInteger(radix = 10)
    private val OFFSET_BASIS64 = "14695981039346656037".toBigInteger(radix = 10)
    private val MOD64 = "2".toBigInteger(radix = 10).pow(64)

    private fun Byte.toBigInteger() : BigInteger = BigInteger.valueOf(this.toLong().and( 0xff))

    fun fnv1(bytes: ByteArray): BigInteger {
        var hash = OFFSET_BASIS64
        for (bits in bytes) {
            hash = hash
                .multiply(PRIME64)
                .mod(MOD64)
                .xor(bits.toBigInteger())
        }
        return hash
    }

    fun fnv1a(bytes: ByteArray): BigInteger {
        var hash = OFFSET_BASIS64
        for (bits in bytes) {
            hash = hash
                .xor(bits.toBigInteger())
                .multiply(PRIME64)
                .mod(MOD64)
        }
        return hash
    }
}
