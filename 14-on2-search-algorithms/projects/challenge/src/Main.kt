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

import bubblesort.bubbleSort
import challenges.biggestDuplicate
import challenges.rev
import challenges.rightAlign
import insertionsort.insertionSort
import selectionsort.selectionSort

fun main() {
  "bubble sort" example {
    val list = arrayListOf(9, 4, 10, 3)
    println("Original: $list")
    list.bubbleSort(true)
    println("Bubble sorted: $list")
  }
  "selection sort" example {
    val list = arrayListOf(9, 4, 10, 3)
    println("Original: $list")
    list.selectionSort(true)
    println("Bubble sorted: $list")
  }
  "insertion sort" example {
    val list = arrayListOf(9, 4, 10, 3)
    println("Original: $list")
    list.insertionSort(true)
    println("Bubble sorted: $list")
  }
  "align right" example  {
    val list = mutableListOf(3, 4, 134, 3, 3, 5, 6, 3, 5, 6, 1, 0)
    println("Original: $list")
    val element = 3
    list.rightAlign(element)
    println("Right align element $element: $list")
  }
  "biggest duplicate" example  {
    val list = mutableListOf(3, 4, 14, 23, 134, 5, 36, 31, 15, 6, 1, 0)
    println("Original: $list")
    val element = list.biggestDuplicate()
    println("Biggest duplicate element: $element")
  }

  "reverse" example  {
    val list = mutableListOf(3, 4, 14, 0, 23, 134, 5, 36, 31, 15, 6, 1, 0)
    println("Original: $list")
    list.rev()
    println("Reverse: $list")
  }
}
