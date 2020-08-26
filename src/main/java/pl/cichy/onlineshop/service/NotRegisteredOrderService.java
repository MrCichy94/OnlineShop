package pl.cichy.onlineshop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.cichy.onlineshop.model.NotRegisteredOrder;
import pl.cichy.onlineshop.model.repository.NotRegisteredOrderRepository;

import java.util.Optional;

@Service
public class NotRegisteredOrderService {

    private final NotRegisteredOrderRepository notRegisteredOrderRepository;

    public NotRegisteredOrderService(NotRegisteredOrderRepository notRegisteredOrderRepository) {
        this.notRegisteredOrderRepository = notRegisteredOrderRepository;
    }

    public Optional<NotRegisteredOrder> findById(Integer id) {
        return notRegisteredOrderRepository.findById(id);
    }

    public Page<NotRegisteredOrder> findAll(Pageable page){
        return notRegisteredOrderRepository.findAll(page);
    }

    public void deleteById(Integer id){
        notRegisteredOrderRepository.deleteById(id);
    }

    public NotRegisteredOrder save (NotRegisteredOrder entity){
        return notRegisteredOrderRepository.save(entity);
    }

    public boolean existsById(Integer id){
        return notRegisteredOrderRepository.existsById(id);
    }
}
