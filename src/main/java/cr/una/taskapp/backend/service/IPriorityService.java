package cr.una.taskapp.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * PriorityService
 *
 * The Service for Priority
 */
@Service
@Transactional
public interface IPriorityService {
    public Priority findById (final long id);
}
