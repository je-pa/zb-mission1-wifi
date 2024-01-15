package service;

import dto.BookmarkDto;
import repository.BookmarkRepository;

import java.util.List;

public class BookmarkService {
    private BookmarkRepository bookmarkRepository;

    public BookmarkService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }


    public int add(String wifiManageNo, int bookmarkGroupId) {
        return bookmarkRepository.add(wifiManageNo, bookmarkGroupId);
    }

    public List<BookmarkDto> getList() {
        return bookmarkRepository.getList();
    }

    public BookmarkDto getById(int id) {
        return bookmarkRepository.getById(id);
    }

    public int deleteById(int id) {
        return bookmarkRepository.deleteById(id);
    }
}
