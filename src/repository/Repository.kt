package repository

class Repository<T> {
    protected val items : MutableList<T> = mutableListOf()
    fun add(item:T): Boolean{
      return  items.add(item)
    }

}