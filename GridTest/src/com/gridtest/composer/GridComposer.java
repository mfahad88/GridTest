package com.gridtest.composer;

import java.io.IOException;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;
import org.zkoss.zul.Rows;

import retrofit2.Call;
import retrofit2.Response;


public class GridComposer extends GenericForwardComposer {
	Button btn_fetch;
	Grid grid;
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
	}
	
	public void onClick$btn_fetch() throws IOException {
		Call<List<PostBean>> call=ApiClient.getInstance().post();
		Rows rows=new Rows();
		
		Response<List<PostBean>> response= call.execute();
		if(response.isSuccessful()) {
			
			for(PostBean bean:response.body()) {
				Row row=new Row();
				Label lbl_userId=new Label(bean.getUserId().toString());
				
				row.setHflex("2");
				row.appendChild(lbl_userId);
				rows.appendChild(row);
				
				Label lbl_Id=new Label(bean.getId().toString());
				
				row.setHflex("2");
				row.appendChild(lbl_Id);
				rows.appendChild(row);
				
				Label lbl_title=new Label(bean.getTitle().toString());
				
				row.setHflex("4");
				row.appendChild(lbl_title);
				rows.appendChild(row);
				
				Label lbl_body=new Label(bean.getBody().toString());
				
				row.setHflex("4");
				row.appendChild(lbl_body);
				rows.appendChild(row);
			}
			
			grid.appendChild(rows);
		}
	}
	
}
