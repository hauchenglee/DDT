package com.sample.ddt.model;

import lombok.Data;

/**
 * - page: 当前第几页
 * - size: 当前页数总共多少数据
 * - total: 总数据量
 * <p>
 * PageRequest pageable = PageRequest.of(1,2); //第1个参数是页数，从0开始。第2个参数为每页条数
 * Page<Book> page = bookDao.findAll(pageable);
 * System.out.println("总页数：" + page.getTotalPages());
 * System.out.println("总记录数：" + page.getTotalElements());
 * System.out.println("查询结果：" + page.getContent());
 * System.out.println("当前页数：" + (page.getNumber()+1));
 * System.out.println("当前记录数：" + page.getNumberOfElements());
 * System.out.println("每页记录数：" + page.getSize());
 * https://www.hangge.com/blog/cache/detail_2614.html
 */
@Data
public class Pagination {
    private int page;
    private int size;
    private int total;
}
