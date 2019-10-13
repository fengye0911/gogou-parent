package cn.itsource.gogou.mapper;

import cn.itsource.gogou.domain.Brand;
import cn.itsource.gogou.query.BrandQuery;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 品牌信息 Mapper 接口
 * </p>
 *
 * @author yun
 * @since 2019-10-12
 */
@Component
public interface BrandMapper extends BaseMapper<Brand> {

    IPage<Brand> queryPage(Page page, @Param("query") BrandQuery query);
}
