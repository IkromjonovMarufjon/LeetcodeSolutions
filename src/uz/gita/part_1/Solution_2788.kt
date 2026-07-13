package uz.gita.part_1

class Solution_2788 {

    fun splitWordsBySeparator(words: List<String>, separator: Char): List<String> {
        val ls = ArrayList<String>()

        for (word in words)
            ls.addAll(word.split(separator).filter { it.isNotEmpty() })

        return ls
    }
}