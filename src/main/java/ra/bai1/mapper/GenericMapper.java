package ra.bai1.mapper;

public interface GenericMapper<E,R,S> {
    E mapperRequestToEntity(R r);
    S mapperEntityToResponse(E e);
}
