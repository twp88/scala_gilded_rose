package com.gildedrose

class GildedRose(val items: Array[Item]) {
  def updateQuality(){
    items.foreach( item => update(item))
  }

  def update(item: Item) {
    item.name match {
      case "Aged Brie" => updateBrie(item)
      case "Sulfuras, Hand of Ragnaros" => updateSulfuras(item)
      case "Backstage passes to a TAFKAL80ETC concert" => updateBackstage(item)
      case _ => updateNormal(item)
    }
  }

  private def updateBrie(item: Item): Unit = {
    if(item.quality == 50) return else increaseQuality(item, 1)
    item.sellIn -= 1
  }

  private def updateSulfuras(item: Item): Unit = {
    item.sellIn -= 1
  }

  private def updateBackstage(item: Item): Unit = {
    item.sellIn match {
      case x if 1 to 5 contains x => increaseQuality(item, 3)
      case x if 6 to 10 contains x => increaseQuality(item, 2)
      case _ => increaseQuality(item, 1)
    }
  }

  private def updateNormal(item: Item): Unit = {
    if (item.quality == 0) return
    if (item.sellIn == 0) reduceQuality(item, 2) else reduceQuality(item, 1)

    item.sellIn -= 1
  }

  def reduceQuality(item: Item, quantity: Int): Unit = { item.quality -= quantity }
  def increaseQuality(item: Item, quantity: Int): Unit = { item.quality += quantity }
}