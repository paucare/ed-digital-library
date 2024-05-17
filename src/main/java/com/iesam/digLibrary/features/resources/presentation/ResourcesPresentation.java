package com.iesam.digLibrary.features.resources.presentation;
import java.util.List;
import java.util.Scanner;

import com.iesam.digLibrary.features.resources.domain.Resources;
import com.iesam.digLibrary.features.resources.books.data.local.BooksFileLocalDataSource;
import com.iesam.digLibrary.features.resources.books.domain.*;
import com.iesam.digLibrary.features.resources.books.data.*;
import com.iesam.digLibrary.features.resources.music.data.MusicDataRepository;
import com.iesam.digLibrary.features.resources.music.data.local.MusicFileLocalDataSource;
import com.iesam.digLibrary.features.resources.music.domain.*;
import com.iesam.digLibrary.features.user.data.UserDataRepository;
import com.iesam.digLibrary.features.user.data.local.UserFileLocalDataSource;
import com.iesam.digLibrary.features.user.domain.UpdateUserUseCase;
import com.iesam.digLibrary.features.user.domain.User;


public class ResourcesPresentation {
    static Scanner sc = new Scanner(System.in);
    public static void showResourceForm(){
        Resources p = showBasicData();
        System.out.println("What kind of resource is? 1.Books 2.CD");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option) {

            case 1:
                System.out.println("Number of pages: ");
                int extension = sc.nextInt();
                sc.nextLine();
                Books resourceBook = new Books(p.id,p.name, p.year, p.description, extension);
                SaveBookUseCase useCaseBook = new SaveBookUseCase(new BooksDataRepository(new BooksFileLocalDataSource()));
                useCaseBook.execute(resourceBook);
                System.out.println("The book " + resourceBook.name + " was saved");
                break;
            case 2:
                System.out.println("Number of songs: ");
                int numSongs = sc.nextInt();
                sc.nextLine();
                Music resourceMusic = new Music(p.id, p.name, p.year, p.description, numSongs);
                SaveMusicUseCase useCaseMusic = new SaveMusicUseCase(new MusicDataRepository(new MusicFileLocalDataSource()));
                useCaseMusic.execute(resourceMusic);
                System.out.println("The book " + resourceMusic.name + " was saved");
                break;
            default:
                System.out.println("Please enter a valid option");
                break;
        }
    }
    public static void deleteResourceById(){
        System.out.println("What kind of resource you want to delete? 1.Books 2.Music");
        int option = sc.nextInt();
        sc.nextLine();
        switch (option){
            case 1:
                System.out.println("Enter the book id to delete: ");
                int idBook = sc.nextInt();
                DeleteBookUseCase useCaseBook = new DeleteBookUseCase(new BooksDataRepository(new BooksFileLocalDataSource()));
                useCaseBook.execute(idBook);
                System.out.println("The resource which id is " + idBook + " was deleted succesfully");
                break;
            case 2:
                System.out.println("Enter the CD id to delete: ");
                int idMusic = sc.nextInt();
                DeleteMusicUseCase useCaseMusic = new DeleteMusicUseCase(new MusicDataRepository(new MusicFileLocalDataSource()));
                useCaseMusic.execute(idMusic);
                System.out.println("The resource which id is " + idMusic + " was deleted succesfully");
                break;
            default:
                System.out.println("Please enter a valid option");
                break;
        }

    }
    public static void updateBook(){
        System.out.println("What kind of resource you want to delete? 1.Books 2.Music");
        int option = sc.nextInt();
        sc.nextLine();

        switch (option){
            case 1:
                System.out.println("Enter the book id to update");
                Resources p = showUpdateForm();
                System.out.println("Number of pages: ");
                int extension = sc.nextInt();
                sc.nextLine();

                Books updatedBook = new Books(p.id,p.name,p.year,p.description,extension);
                UpdateBookUseCase useCaseBook = new UpdateBookUseCase(new BooksDataRepository(new BooksFileLocalDataSource()));
                useCaseBook.execute(updatedBook);
                break;
            case 2:
                System.out.println("Enter the CD id to update");
                Resources t = showUpdateForm();
                System.out.println("Number of songs: ");
                int numSongs = sc.nextInt();
                sc.nextLine();
                Music updatedMusic = new Music(t.id,t.name,t.year,t.description,numSongs);
                UpdateMusicUseCase useCaseMusic= new UpdateMusicUseCase(new MusicDataRepository(new MusicFileLocalDataSource()));
                useCaseMusic.execute(updatedMusic);
                break;
            default:
                System.out.println("Please enter a valid option");
                break;
        }
    }
    public static void getAllRegisters(){
        System.out.println("What kind of resource you want to get the full list? 1.Books 2.Music");
        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                System.out.println("Next a list of all our books will be shown");
                GetBooksUseCase useCaseBooks = new GetBooksUseCase(new BooksDataRepository(new BooksFileLocalDataSource()));
                List<Books> booksList = useCaseBooks.execute();
                for (Books book : booksList) {
                    System.out.println(book.name + " (" + book.year + ") " + book.extension + " pages");
                }
                    break;
                case 2:
                    System.out.println("Next a list of all our CDs will be shown");
                    GetAllMusicUseCase useCaseMusic = new GetAllMusicUseCase(new MusicDataRepository(new MusicFileLocalDataSource()));
                    List<Music> musicList = useCaseMusic.execute();
                    for (Music music : musicList) {
                        System.out.println(music.name + " (" + music.year + ") " + music.numSongs + " songs");
                    }
                    break;
            default:
                System.out.println("Please enter a valid option");
                break;

        }
    }
    public static Resources showBasicData(){
        System.out.println("Introduce the digital resource basic data you want to create");
        System.out.println("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Year of release/publication: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.println("Description: ");
        String description = sc.nextLine();

        Resources r = new Resources(id,name,year,description);
        return r;
    }
    public static Resources showUpdateForm(){
        int unchangedId = sc.nextInt();
        sc.nextLine();
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Year: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.println("Description: ");
        String description = sc.nextLine();
        Resources r= new Resources(unchangedId,name,year,description);
        return r;
    }
}



