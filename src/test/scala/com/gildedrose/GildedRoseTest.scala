package com.gildedrose

import org.scalatest._


class GildedRoseTest extends FlatSpec with Matchers {
  behavior of "foo"
  it should "have a name" in {
    var items = Array[Item](new Item("foo", 1, 2))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).name should equal ("foo")
  }

  it should "have a sell in value" in {
    var app = appForFoo()

    app.items(0).sellIn should equal (0)
  }

  it should "have a quality" in {
    var app = appForFoo()

    app.items(0).quality should equal (0)
  }

  it should "decrease quality" in {
    var items = Array[Item](new Item("foo", 1, 1))
    var app = new GildedRose(items)

    app.updateQuality()

    app.items(0).quality should equal(0)
  }

      it should "decrease sellIn" in {
        var items = Array[Item](new Item("foo", 1, 1))
        var app = new GildedRose(items)

        app.updateQuality()

        app.items(0).sellIn should equal(0)
      }

      it should "decrease quality 2x faster" in {
        var items = Array[Item](new Item("foo", 0, 2))
        var app = new GildedRose(items)

        app.updateQuality()

        app.items(0).quality should equal(0)
      }

      it should "have no negative quality" in {
        var items = Array[Item](new Item("foo", 0, 0))
        var app = new GildedRose(items)

        app.updateQuality()

        app.items(0).quality should equal(0)
      }

    behavior of "Aged Brie"

      it should "increase in quality" in {
        var items = Array[Item](new Item("Aged Brie", 1, 2))

        GildedRose(items).updateQuality()

        GildedRose(items).items(0).quality should equal(3)
      }

      it should "never have quality > 50" in {
        var items = Array[Item](new Item("Aged Brie", 1, 50))

        GildedRose(items).updateQuality()

        GildedRose(items).items(0).quality should equal(50)
      }

    behavior of "Sulfuras"

      it should "never decrease in value" in {
        var items = Array[Item](new Item("Sulfuras, Hand of Ragnaros", 1, 30))

        GildedRose(items).updateQuality()

        GildedRose(items).items(0).quality should equal(30)
      }

    behavior of "Backstage Passes"
      it should "increase in quality" in {
        var items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 11, 3))

        GildedRose(items).updateQuality()

        GildedRose(items).items(0).quality should equal(4)
      }

      it should "increase in quality +2" in {
        var items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 10, 3))

        GildedRose(items).updateQuality()

        GildedRose(items).items(0).quality should equal(5)
      }

      it should "increase in quality +3" in {
        var items = Array[Item](new Item("Backstage passes to a TAFKAL80ETC concert", 5, 3))

        GildedRose(items).updateQuality()

        GildedRose(items).items(0).quality should equal(6)
      }


  def itemFoo()= {
    Array[Item](new Item("foo", 0, 0))
  }

  def GildedRose(items: Array[Item]) = {
    new GildedRose(items)
  }

  def appForFoo(): GildedRose = {
    var items = itemFoo()
    GildedRose(items)
  }
}