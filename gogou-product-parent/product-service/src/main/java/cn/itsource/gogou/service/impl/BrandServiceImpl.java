package cn.itsource.gogou.service.impl;

import cn.itsource.gogou.domain.Brand;
import cn.itsource.gogou.mapper.BrandMapper;
import cn.itsource.gogou.query.BrandQuery;
import cn.itsource.gogou.service.IBrandService;
import cn.itsource.gogou.util.LetterUtil;
import cn.itsource.gogou.util.PageList;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 品牌信息 服务实现类
 * </p>
 *
 * @author yun
 * @since 2019-10-12
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageList<Brand> queryPage(BrandQuery query) {
        IPage<Brand> brandPage =
                brandMapper.queryPage(new Page(query.getPageNum(), query.getPageSize()), query);
        PageList<Brand> pageList = new PageList<>(brandPage.getTotal(),brandPage.getRecords());
        return pageList;
    }

    /**
     * 保存
     * @param brand
     * @return
     */
    @Override
    public boolean save(Brand brand) {
        System.out.println(brand);
        brand.setProductTypeId(brand.getProductType().getId());
        brand.setFirstLetter(LetterUtil.getFirstLetter(brand.getName()).toUpperCase());
        brand.setCreateTime(System.currentTimeMillis());
        return super.save(brand);
    }

    /**
     * 更新
     * @param brand
     * @return
     */
    @Override
    public boolean updateById(Brand brand) {
        System.out.println("修改"+brand);
        brand.setProductTypeId(brand.getProductType().getId());
        brand.setFirstLetter(LetterUtil.getFirstLetter(brand.getName()).toUpperCase());
        brand.setUpdateTime(System.currentTimeMillis());
        return super.updateById(brand);
    }
}
