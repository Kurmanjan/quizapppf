package kg.kurmanjan.quizapp.core;

public interface IBaseCallBack<T> {

    void onSuccess(T result);

    void onFailure(Exception e);
}
