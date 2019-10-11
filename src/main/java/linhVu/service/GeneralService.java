package linhVu.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GeneralService<E> {
    Page<E> findAll(Pageable pageable);
    Page<E> findAllByNameContaining(String name, Pageable pageable);
    E findById(Long id);
//    List<E> findAll();
}
