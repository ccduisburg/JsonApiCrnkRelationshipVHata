package com.cemoli.crnk.client;


import com.cemoli.crnk.domain.model.Book;
import com.cemoli.crnk.domain.model.BookCategory;
import io.crnk.client.CrnkClient;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Webclient {


        private static final Logger LOGGER = LoggerFactory.getLogger(com.cemoli.crnk.client.Webclient.class);

        private CrnkClient crnkClient = new CrnkClient("http://localhost:9090/cemoli/api");

        private ResourceRepositoryV2<Book, Long> bookResourceRepositoryV2;
        private ResourceRepositoryV2<BookCategory, Long> bookCategoryResourceRepositoryV2;


        @PostConstruct
        public void init() {
            bookResourceRepositoryV2 = crnkClient.getRepositoryForType(Book.class);
            bookCategoryResourceRepositoryV2 = crnkClient.getRepositoryForType(BookCategory.class);

        }


        public Book findOneBook(Long id){
            Book result=bookResourceRepositoryV2.findOne(id,new QuerySpec(Book.class));
            LOGGER.info("found {}", result.toString());
            return result;
        }

    public BookCategory findOneBookCategory(Long id){
        BookCategory result=bookCategoryResourceRepositoryV2.findOne(id,new QuerySpec(BookCategory.class));
        LOGGER.info("found {}", result.toString());
        return result;
    }

    public List<Book> findAllBook(){
            return bookResourceRepositoryV2.findAll(new QuerySpec(Book.class));

    }

    public List<BookCategory> findAllBookCategory(){
            return bookCategoryResourceRepositoryV2.findAll(new QuerySpec(BookCategory.class));
    }

    }
