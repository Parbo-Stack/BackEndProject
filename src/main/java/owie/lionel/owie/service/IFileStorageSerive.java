package owie.lionel.owie.service;


import owie.lionel.owie.domain.FileDB;
import java.util.stream.Stream;

public interface IFileStorageSerive {

    FileDB getFile (String id);
    Stream<FileDB> getAllFiles();
}
