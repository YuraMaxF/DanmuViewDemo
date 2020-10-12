package com.yuramax.danmuviewdemo;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * author : weijun
 * e-mail : 1301892339@qq.com
 * time   : 2020/10/12
 * desc   :
 * version: 1.0
 */
public class DanmuChildAdapter extends BaseQuickAdapter<Integer, BaseViewHolder> {

    public DanmuChildAdapter(@Nullable List<Integer> data) {
        super(R.layout.item_danmu, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, Integer item) {
        int newPos = holder.getAdapterPosition() % getData().size();
        holder.setText(R.id.tv,"哈哈哈哈" + getData().get(newPos));
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }
}
