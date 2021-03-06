package com.example.demo.src.home;

import com.example.demo.config.BaseException;
import com.example.demo.src.home.model.*;
import com.example.demo.src.user.model.GetUserRes;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;

@Service
public class HomeProvider {

    private final HomeDao homeDao;
    private final JwtService jwtService;


    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public HomeProvider(HomeDao homeDao, JwtService jwtService) {
        this.homeDao = homeDao;
        this.jwtService = jwtService;
    }

//    public List<GetUserCategoryRes> getUserCatoeries() throws BaseException {
//        try{
//            List<GetUserCategoryRes> getUserCategoryRes = homeDao.getUserCategories();
//            return getUserCategoryRes;
//        }
//        catch (Exception exception) {
//            throw new BaseException(DATABASE_ERROR);
//        }
//    }

    public List<GetQuoteRes> getQuotes() throws BaseException {
        try{
            List<GetQuoteRes> getQuoteRes = homeDao.getQuotes();
            return getQuoteRes;
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public GetCountRes getCountsByCategoryId(int categoryId) throws BaseException {
        try {
            int userIdx = jwtService.getUserIdx();
            GetCountRes getCountRes = homeDao.getCount(userIdx,categoryId);
            return getCountRes;
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public List<GetCountAllRes> getCountAll() throws BaseException {
        try {
            List<GetCountAllRes> getCountAllRes = homeDao.getCountAll();
            return getCountAllRes;
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public List<GetCategoryAllRes> getCategoryAll() throws BaseException {
        try{
            List<GetCategoryAllRes> getCategoryAllRes = homeDao.getCategoryAll();
            return getCategoryAllRes;
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

}
