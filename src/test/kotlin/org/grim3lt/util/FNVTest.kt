package org.grim3lt.util

import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test

internal class FNVTest {

    @Test
    fun fnv1() {
        SoftAssertions.assertSoftly {
            it.assertThat(FNV.fnv1("".toByteArray()).toString(16)).isEqualTo("cbf29ce484222325")
            it.assertThat(FNV.fnv1("h".toByteArray()).toString(16)).isEqualTo("af63bd4c8601b7b7")
            it.assertThat(FNV.fnv1("ho".toByteArray()).toString(16)).isEqualTo("8326007b4eb2b9a")
            it.assertThat(FNV.fnv1("hog".toByteArray()).toString(16)).isEqualTo("d8c4c7186b9b16c9")
            it.assertThat(FNV.fnv1("hoge".toByteArray()).toString(16)).isEqualTo("f175177ed887b7ee")
            val ipsum =
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            it.assertThat(FNV.fnv1(ipsum.toByteArray()).toString(16)).isEqualTo("6544e3dfaa0e2985")
            it.assertAll()
        }
    }

    @Test
    fun fnv1a() {
        SoftAssertions.assertSoftly {
            it.assertThat(FNV.fnv1a("".toByteArray()).toString(16)).isEqualTo("cbf29ce484222325")
            it.assertThat(FNV.fnv1a("h".toByteArray()).toString(16)).isEqualTo("af63e54c8601fbd7")
            it.assertThat(FNV.fnv1a("ho".toByteArray()).toString(16)).isEqualTo("8ba5907b55eb9a8")
            it.assertThat(FNV.fnv1a("hog".toByteArray()).toString(16)).isEqualTo("335f17192ff5babd")
            it.assertThat(FNV.fnv1a("hoge".toByteArray()).toString(16)).isEqualTo("404f17cc7e8c7d08")
            val ipsum =
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            it.assertThat(FNV.fnv1a(ipsum.toByteArray()).toString(16)).isEqualTo("a55cd0397ebd239d")
            it.assertAll()
        }
    }
}
