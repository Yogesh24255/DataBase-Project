package com.dependency2.Project2.Services;

import com.dependency2.Project2.Entity.BooksInTheLibraryEntity;
import com.dependency2.Project2.Entity.UserBookHistoryEntity;
import com.dependency2.Project2.Entity.UserOfLibraryEntity;
import com.dependency2.Project2.Repository.BooksInTheLibraryRepository;
import com.dependency2.Project2.Repository.UserBookHistoryRepository;
import com.dependency2.Project2.Repository.UserOfLibraryRepository;
import com.dependency2.Project2.dto.BooksInTheLibrary;
import com.dependency2.Project2.dto.UserBookHistory;
import com.dependency2.Project2.dto.UserOfLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LibraryManagementImplementation implements LibraryService {

    @Autowired
    UserOfLibraryRepository userOfLibraryRepository;

    @Autowired
    BooksInTheLibraryRepository booksInTheLibraryRepository;

    @Autowired
    UserBookHistoryRepository userBookHistoryRepository;

    @Override
    public void addBook(BooksInTheLibrary booksInTheLibrary) {

        booksInTheLibraryRepository.save (new BooksInTheLibraryEntity (booksInTheLibrary.getBookId (), booksInTheLibrary.getBookName (), booksInTheLibrary.getBookWriter (), booksInTheLibrary.getBookSummary (), booksInTheLibrary.getBookCategory ()));
    }

    @Override
    public void addUser(UserOfLibrary userOfLibrary) {
        userOfLibraryRepository.save (new UserOfLibraryEntity (userOfLibrary.getUserId (),userOfLibrary.getUserName (), userOfLibrary.getAddress (),userOfLibrary.getPhoneNo ()));

    }

       @Override
    public List<BooksInTheLibrary> getBooksInTheLibrary() {
        List<BooksInTheLibrary> booksInTheLibraries = new ArrayList<> ();

        for(BooksInTheLibraryEntity booksInTheLibraryEntity: booksInTheLibraryRepository.findAll()){
            BooksInTheLibrary booksInTheLibrary = new BooksInTheLibrary ();
            booksInTheLibrary.setBookId (booksInTheLibraryEntity.getBookId ());
            booksInTheLibrary.setBookName (booksInTheLibraryEntity.getBookName ());
            booksInTheLibrary.setBookWriter (booksInTheLibraryEntity.getBookWriter ());
            booksInTheLibrary.setBookSummary (booksInTheLibraryEntity.getBookSummary ());
            booksInTheLibrary.setBookCategory (booksInTheLibraryEntity.getBookCategory ());
            booksInTheLibraries.add (booksInTheLibrary);
        }
        return booksInTheLibraries;
    }

        @Override
        public void addIssue(UserBookHistory userBookHistory) {

            userBookHistoryRepository.save (new UserBookHistoryEntity(userBookHistory.getUserId(),userBookHistory.getIsueDate(), userBookHistory.getReturnDate(), userBookHistory.getBookId(), userBookHistory.getTransactionId()));
    }

        @Override
        public void addReturnDate(UserBookHistory userBookHistory) {
            for(UserBookHistoryEntity userBookHistoryEntity:userBookHistoryRepository.findAll ()){
                if(userBookHistoryEntity.getUserid ()==userBookHistory.getUserId () && userBookHistoryEntity.getReturnDate ()== null){
                    userBookHistoryEntity.setReturnDate (userBookHistory.getReturnDate ());
                    userBookHistoryRepository.save (userBookHistoryEntity);

                }
            }
        }


        @Override
        public BooksInTheLibrary addPopularBook() {
        Iterable<UserBookHistoryEntity>list = userBookHistoryRepository.findAll ();
            Map<Integer,Integer> map = new HashMap<> ();
            for(UserBookHistoryEntity userBookHistoryEntity:list){
                if(map.containsKey ((userBookHistoryEntity.getBookid ()))){
                    map.put (userBookHistoryEntity.getBookid (),map.get (userBookHistoryEntity.getBookid ()) +1);
                }
                else
                {
                    map.put (userBookHistoryEntity.getBookid (),1);
                }

            }
           // Integer max = Collections.max (map.values ());
            //System.out.println (max );
            Set<Map.Entry<Integer,Integer>> entrySet=map.entrySet ();
            int maxCount = 0;
            int maxId = 0;
            for(Map.Entry<Integer,Integer>entry:entrySet){
                if(entry.getValue ()>maxCount){
                    maxCount = entry.getValue ();
                    maxId = entry.getKey ();
                }
            }

            BooksInTheLibrary booksInTheLibrary = new BooksInTheLibrary ();
            Iterable<BooksInTheLibraryEntity> books = booksInTheLibraryRepository.findAll ();
            for(BooksInTheLibraryEntity inTheLibraryEntity:books){
                if(inTheLibraryEntity.getBookId () == maxId){
                    booksInTheLibrary.setBookId (inTheLibraryEntity.getBookId ());
                    booksInTheLibrary.setBookName (inTheLibraryEntity.getBookName ());
                    booksInTheLibrary.setBookWriter (inTheLibraryEntity.getBookWriter ());
                    booksInTheLibrary.setBookSummary (inTheLibraryEntity.getBookSummary ());
                    booksInTheLibrary.setBookCategory (inTheLibraryEntity.getBookCategory ());
                }
            }

            // public Book popular()
            //    {
            //        Iterable<UserBookHistoryEntity>list =  userBookHistoryRepository.findAll();
            //        HashMap<Integer,Integer>mp = new HashMap<>();
            //        for(UserBookHistoryEntity x: list){
            //            if (mp.containsKey( x.getBookId() ))
            //                mp.put(x.getBookId(), mp.get(x.getBookId()) + 1);
            //            else
            //                mp.put(x.getBookId(), 1);
            //        }
            ////        Integer max = Collections.max(mp.values());
            ////        System.out.println(max);
            //        Set<Map.Entry<Integer, Integer>> entrySet = mp.entrySet();
            //        int maxCount = 0;
            //        int maxId = 0;
            //        for (Map.Entry<Integer, Integer> entry : entrySet)
            //        {
            //            if (entry.getValue() > maxCount)
            //            {
            //                maxCount = entry.getValue();
            //                maxId = entry.getKey();
            //            }
            //        }
            //
            //        Book book = new Book();
            //        Iterable<BookEntity> books = bookRepository.findAll();
            //        for (BookEntity i : books) {
            //            if (i.getId() == maxId) {
            //                book.setId(i.getId());
            //                book.setName(i.getName());
            //                book.setWriter(i.getWriter());
            //                book.setSummary(i.getSummary());
            //                book.setCategory(i.getCategory());
            //            }
            //        }
            //
            //        return book;
            //    }
          //  for(B)

        return booksInTheLibrary;
    }

    @Override
    public UserOfLibrary getBookWriterWithMaxUser() {

        Iterable<UserBookHistoryEntity>list = userBookHistoryRepository.findAll ();
        HashMap<Integer,Integer> map = new HashMap<> ();
        for(UserBookHistoryEntity userBookHistoryEntity:list){
            if(map.containsKey (userBookHistoryEntity.getUserid ())){
                map.put (userBookHistoryEntity.getUserid (),map.get (userBookHistoryEntity.getUserid ()) +1);
            }
            else{
                map.put (userBookHistoryEntity.getUserid (),1);
            }
        }
        Set<Map.Entry<Integer,Integer>> entrySet = map.entrySet ();
        int maxCount =0;
        int maxId=0;
        for(Map.Entry<Integer,Integer>entry:entrySet){
            if(entry.getValue ()>maxCount){
                maxCount = entry.getValue ();
                maxId = entry.getKey ();
            }
        }
        UserOfLibrary userOfLibrary = new UserOfLibrary ();
        Iterable<UserOfLibraryEntity> user = userOfLibraryRepository.findAll ();
        for(UserOfLibraryEntity userOfLibraryEntity:user){
            if(userOfLibraryEntity.getUserId ()==maxId){
                userOfLibrary.setUserId (userOfLibraryEntity.getUserId ());
                userOfLibrary.setUserName (userOfLibraryEntity.getUserName ());
                userOfLibrary.setAddress (userOfLibraryEntity.getAddress ());
                userOfLibrary.setPhoneNo (userOfLibraryEntity.getPhoneNo ());
            }
        }

        //    Iterable<UserBookHistoryEntity>list = userBookHistoryRepository.findAll();
        //    HashMap<Integer,Integer>mp = new HashMap<>();
        //    for(UserBookHistoryEntity x:list){
        //        if (mp.containsKey( x.getUserId()))
        //            mp.put(x.getUserId(), mp.get(x.getUserId()) + 1);
        //        else
        //            mp.put(x.getUserId(), 1);
        //    }
        //    Set<Map.Entry<Integer, Integer>> entrySet = mp.entrySet();
        //    int maxCount = 0;
        //    int maxId = 0;
        //    for (Map.Entry<Integer, Integer> entry : entrySet)
        //    {
        //        if (entry.getValue() > maxCount)
        //        {
        //            maxCount = entry.getValue();
        //            maxId = entry.getKey();
        //        }
        //    }
        //
        //    User user = new User();
        //    Iterable<UserEntity> users = userRepository.findAll();
        //    for (UserEntity i : users) {
        //        if (i.getId() == maxId) {
        //            user.setId(i.getId());
        //            user.setName(i.getName());
        //            user.setAddress(i.getAddress());
        //            user.setPhoneNumber(i.getPhoneNumber());
        //        }
        //    }
        //
        //    return user;
        //
        //
        //}
        return userOfLibrary;
    }
}
