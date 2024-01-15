package service;

import entity.BookmarkGroup;
import repository.BookmarkGroupRepository;

import java.util.List;

public class BookmarkGroupService {
    private BookmarkGroupRepository bookmarkGroupRepository;

    public BookmarkGroupService(BookmarkGroupRepository bookmarkGroupRepository) {
        this.bookmarkGroupRepository = bookmarkGroupRepository;
    }

    public List<BookmarkGroup> getList() {
        return bookmarkGroupRepository.getList();
    }

    public int add(String name, int order) {
        return bookmarkGroupRepository.add(name, order);
    }

    public BookmarkGroup get(int id) {
        return bookmarkGroupRepository.getById(id);
    }

    public int edit(int id, String name, int order) {
        return bookmarkGroupRepository.editByIdAndNameAndOrder(id, name, order);
    }

    public int delete(int id) {
        return bookmarkGroupRepository.deleteById(id);
    }
}
