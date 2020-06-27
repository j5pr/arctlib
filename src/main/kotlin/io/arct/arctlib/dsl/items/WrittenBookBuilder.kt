package io.arct.arctlib.dsl.items

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.BookMeta

open class WrittenBookBuilder(published: Boolean) : ItemBuilder(if (published) Material.WRITTEN_BOOK else Material.BOOK_AND_QUILL) {
    var pages: MutableList<String> = mutableListOf()
    var pagesSet: MutableList<Pair<Int, String>> = mutableListOf()
    var title: String? = null
    var author: String? = null

    fun page(vararg pages: String) =
        this.pages.addAll(pages)

    fun page(page: Int, content: String) =
        pagesSet.add(Pair(page, content))

    override fun build(): ItemStack {
        val item = super.build()
        val meta = item.itemMeta as BookMeta

        if (title != null)
            meta.title = title

        if (author != null)
            meta.author = author

        meta.addPage(*pages.toTypedArray())

        for (page in pagesSet)
            meta.setPage(page.first, page.second)



        item.itemMeta = meta
        return item
    }
}