package br.com.safe.pass.repository

fun generatePassword(
    length: Int = 8,
    uniqueChars: Boolean = true,
    lowercase: Boolean = true,
    uppercase: Boolean = false,
    numbers: Boolean = false,
    specialChars: Boolean = false
): String {
    val charPool = mutableListOf<Char>()
    if (lowercase) charPool.addAll(elements = 'a'..'z')
    if (uppercase) charPool.addAll(elements = 'A'..'Z')
    if (numbers) charPool.addAll(elements = '0'..'9')
    if (specialChars) charPool.addAll(elements = "!@#\$%^&*()_-+={}[]|;:'\",.<>/?".toList())

    if (charPool.isEmpty()) {
        charPool.addAll(elements = 'a'..'z')
    }

    val randomString = StringBuilder()
    while (randomString.length < length) {
        val randomChar = charPool.random()
        if (uniqueChars && randomString.contains(randomChar)) continue
        randomString.append(randomChar)
    }

    return randomString.toString()
}