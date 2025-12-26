public interface DiversityTargetService {

    DiversityTarget createTarget(DiversityTarget target);

    DiversityTarget getById(Long id);

    List<DiversityTarget> getAllTargets();

    DiversityTarget updateTarget(Long id, DiversityTarget target);

    void deactivateTarget(Long id);
}
