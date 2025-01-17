/*
 * Copyright (c) 2019 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

class Trie<Key> {

  private val root = TrieNode<Key>(key = null, parent = null)

  fun insert(list: List<Key>) {
    // 1
    var current = root

    // 2
    list.forEach { element ->
      if (current.children[element] == null) {
        current.children[element] = TrieNode(element, current)
      }
      current = current.children[element]!!
    }

    // 3
    current.isTerminating = true
  }

  fun contains(list: List<Key>): Boolean {
    var current = root

    list.forEach { element ->
      val child = current.children[element] ?: return false
      current = child
    }

    return current.isTerminating
  }

  fun remove(list: List<Key>) {
    // 1
    var current = root

    list.forEach { element ->
      val child = current.children[element] ?: return
      current = child
    }

    if (!current.isTerminating) return

    // 2
    current.isTerminating = false

    // 3
    while (current.parent != null && current.children.isEmpty() && !current.isTerminating) {
      current.parent!!.children.remove(current.key)
      current = current.parent!!
    }
  }

  fun collections(prefix: List<Key>): List<List<Key>> {
    // 1
    var current = root

    prefix.forEach { element ->
      val child = current.children[element] ?: return emptyList()
      current = child
    }

    // 2
    return collections(prefix, current)
  }

  private fun collections(prefix: List<Key>, node: TrieNode<Key>?): List<List<Key>> {
    // 1
    val results = mutableListOf<List<Key>>()

    if (node?.isTerminating == true) {
      results.add(prefix)
    }

    // 2
    node?.children?.forEach { (key, node) ->
      results.addAll(collections(prefix + key, node))
    }

    return results
  }

}
