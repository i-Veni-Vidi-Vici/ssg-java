package com.sh.api._01.object;

public class Book {
    private long id;
    private String title;
    private String author;
    private int price;

    public Book(long id, String title, String author, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "Book[id=" + this.id +" title="+this.title + " author="+this.author + "]";
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj)return true;
        if(obj instanceof Book){
            Book book = (Book)obj;
            if(this.id==book.getId() &&this.price== book.getPrice()){
                if(book.getTitle()==null){
                    if(this.title!=null)return false;
                }
                if(book.getAuthor()==null){
                    if(this.author!=null)return false;
                }
                if(!this.title.equals(book.getTitle()) || !this.author.equals(book.getAuthor()))return false;
                else return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        int result  =1;
        final int PRIME = 31;
        result = result*PRIME + (int)id;
        if(this.title!=null){
            result = result * PRIME + this.title.hashCode();
        }
        if(this.author!=null){
            result = result*PRIME+this.author.hashCode();
        }
        result = result*PRIME + this.price;
        return result;
    }
}
