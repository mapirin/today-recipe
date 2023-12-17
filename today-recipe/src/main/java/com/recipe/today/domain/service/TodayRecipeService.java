package com.recipe.
today.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.today.domain.entity.IngredientsListDTO;
import com.recipe.today.domain.entity.ListDTO;
import com.recipe.today.domain.entity.RecipeListDTO;
import com.recipe.today.domain.repository.IngredientsListMapper;
import com.recipe.today.domain.repository.RecipeListMapper;
import com.recipe.today.domain.repository.SeasoningListMapper;

@Service
public class TodayRecipeService {

	@Autowired
	private RecipeListMapper recipeListMapper;

//	@Autowired
//	private IngredientsListMapper ingredientsListMapper;
//	
//	@Autowired
//	private SeasoningListMapper seasoningListMapper;

	/**
	 * 
	 * @return
	 */
	public boolean insertRecipeList(ListDTO listDTO) {
		try {
			
			recipeListMapper.i(listDTO);
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			//
		}
		return true;
	}
	
	/**
	 * 
	 * 
	 * @return 
	 */
	private ListDTO storeInputData() {
		ListDTO listDTO =null;
		
		if(1==1) {
			listDTO = new RecipeListDTO();
		}else if(2==2) {
			listDTO = new IngredientsListDTO();
		}
		
		return listDTO;
	}
	// TODO ログインユーザ確認
	public boolean getUserInfoTableUserExistCheck(String userName) {
//		Integer existCount = expenseUserMapper.userInfoTableUserExistCheck(userName);
//
//		if (existCount > 0) {
//			return false;
//		}
		return true;
	}

	// TODO ログインユーザ確認２
	public boolean getUserInfoTableSelectUserData(String userName, String password) {
//		Integer userDataCount = expenseUserMapper.userInfoTableSelectUserData(userName, password);
//
//		if (userDataCount == 0) {
//			return false;
//		} else {
			return true;
//		}
	}

//	// TODO ユーザId取得
//	public Integer getUserInfoTableSelectId(String userName) {
//		return expenseListOperateMapper.userInfoTableSelectId(userName);
//	} 
//
//	//
//	// TODO セレクトボックスに追加する値取得
//	public List<String> getMethodInfoTableSelectName() {
//		return expenseRegistMapper.methodInfoTableSelectName();
//	}

	/**
//	public List<String> getCategoryInfoTableDepositData() {
//		List<String> depositCategoryList = new ArrayList<>();
//
//		for (CategoryInfo info : expenseRegistMapper.categoryInfoTableSelectData()) {
//			if (info.getCategoryType() == 0) {
//				depositCategoryList.add(info.getCategoryName());
//			}
//		}
//		return depositCategoryList;
//	}
//
//	public List<String> getCategoryInfoTableSpendingData() {
//		List<String> spendingCategoryList = new ArrayList<>();
//
//		for (CategoryInfo info : expenseRegistMapper.categoryInfoTableSelectData()) {
//			if (info.getCategoryType() == 1) {
//				spendingCategoryList.add(info.getCategoryName());
//			}
//		}
//		return spendingCategoryList;
//	}
//
//	//
//	// 入金データ登録
//	@Transactional
//	public void getDepositInfoTableInsertData(DepositManagementForm depositForm, String userName) {
//		DepositInfo depositInfo = new DepositInfo();
//
//		MethodInfo methodInfo = new MethodInfo();
//		methodInfo.setMethodName(depositForm.getDepositMethod());
//		CategoryInfo categoryInfo = new CategoryInfo();
//		categoryInfo.setCategoryType(0);
//		categoryInfo.setCategoryName(depositForm.getDepositCategory());
//
//		// ID取得
//		Integer methodId = expenseRegistMapper.methodInfoTableSelectId(methodInfo.getMethodName());
//		Integer categoryId = expenseRegistMapper.categoryInfoTableSelectId(categoryInfo.getCategoryType(),
//				categoryInfo.getCategoryName());
//		Integer userId = expenseRegistMapper.userInfoTableSelectId(userName);
//
//		BeanUtils.copyProperties(depositForm, depositInfo);
//		depositInfo.setDepositMethodId(methodId);
//		depositInfo.setDepositCategoryId(categoryId);
//		depositInfo.setUserId(userId);
//
//		expenseRegistMapper.depositInfoTableInsertData(depositInfo);
//	}

	// 支出データ登録
	@Transactional
	public void getSpendingInfoTableInsertData(SpendingManagementForm spendingForm, String userName) {
		SpendingInfo spendingInfo = new SpendingInfo();

		MethodInfo methodInfo = new MethodInfo();
		methodInfo.setMethodName(spendingForm.getSpendingMethod());
		CategoryInfo categoryInfo = new CategoryInfo();
		categoryInfo.setCategoryType(１);
		categoryInfo.setCategoryName(spendingForm.getSpendingCategory());
		// ID取得
		Integer methodId = expenseRegistMapper.methodInfoTableSelectId(methodInfo.getMethodName());
		Integer categoryId = expenseRegistMapper.categoryInfoTableSelectId(categoryInfo.getCategoryType(),
				categoryInfo.getCategoryName());
		Integer userId = expenseRegistMapper.userInfoTableSelectId(userName);

		BeanUtils.copyProperties(spendingForm, spendingInfo);
		spendingInfo.setSpendingMethodId(methodId);
		spendingInfo.setSpendingCategoryId(categoryId);
		spendingInfo.setUserId(userId);

		expenseRegistMapper.spendingInfoTableInsertData(spendingInfo);
	}

	//
	// 入金データ一覧検索表示
	public List<DepositExpenseListInfo> getDepositInfoTableAllData(String year, String month, String userName) {

		List<DepositExpenseListInfo> depositDataList = new ArrayList<>();
		Integer userId = expenseListOperateMapper.userInfoTableSelectId(userName);

		for (DepositInfo info : expenseListOperateMapper.depositInfoTableAllData(year, month, userId)) {
			DepositExpenseListInfo listInfo = new DepositExpenseListInfo();

			listInfo.setDepositId(info.getDepositId());
			listInfo.setDepositYear(info.getDepositYear());
			listInfo.setDepositMonth(info.getDepositMonth());
			listInfo.setDepositDay(info.getDepositDay());
			listInfo.setDepositAmount(info.getDepositAmount());
			listInfo.setDepositCommaAmount(String.format("%,d", info.getDepositAmount()));
			// methodNameを取得
			listInfo.setDepositMethod(expenseListOperateMapper.methodInfoTableSelectName(info.getDepositMethodId()));
			// categoryNameを取得
			listInfo.setDepositCategory(
					expenseListOperateMapper.categoryInfoTableSelectName(info.getDepositCategoryId()));
			listInfo.setDepositDetail(info.getDepositDetail());

			depositDataList.add(listInfo);
		}

		return depositDataList;
	}

	// 支出データ一覧検索表示
	public List<SpendingExpenseListInfo> getSpendingInfoTableAllData(String year, String month, String userName) {

		List<SpendingExpenseListInfo> spendingDataList = new ArrayList<>();
		Integer userId = expenseListOperateMapper.userInfoTableSelectId(userName);

		for (SpendingInfo info : expenseListOperateMapper.spendingInfoTableAllData(year, month, userId)) {
			SpendingExpenseListInfo listInfo = new SpendingExpenseListInfo();

			listInfo.setSpendingId(info.getSpendingId());
			listInfo.setSpendingYear(info.getSpendingYear());
			listInfo.setSpendingMonth(info.getSpendingMonth());
			listInfo.setSpendingDay(info.getSpendingDay());
			listInfo.setSpendingAmount(info.getSpendingAmount());
			listInfo.setSpendingCommaAmount(String.format("%,d", info.getSpendingAmount()));
			// methodNameを取得
			listInfo.setSpendingMethod(expenseListOperateMapper.methodInfoTableSelectName(info.getSpendingMethodId()));
			// categoryNameを取得
			listInfo.setSpendingCategory(
					expenseListOperateMapper.categoryInfoTableSelectName(info.getSpendingCategoryId()));
			listInfo.setSpendingDetail(info.getSpendingDetail());

			spendingDataList.add(listInfo);
		}

		return spendingDataList;
	}

	//
	// 合計額を取得
	public Integer getDepositInfoTableSumAmount(String year, String month, Integer userId) {
		Integer depositSumAmount = expenseListOperateMapper.depositInfoTableSumAmount(year, month, userId);
		if (depositSumAmount == null) {
			depositSumAmount = 0;
		}
		return depositSumAmount;
	}

	public Integer getSpendingInfoTableSumAmount(String year, String month, Integer userId) {
		Integer spendingSumAmount = expenseListOperateMapper.spendingInfoTableSumAmount(year, month, userId);
		if (spendingSumAmount == null) {
			spendingSumAmount = 0;
		}
		return spendingSumAmount;
	}

	public Integer getSumAmount(String year, String month, Integer userId) {
		Integer depositSumAmount = getDepositInfoTableSumAmount(year, month, userId);
		Integer spendingSumAmount = getSpendingInfoTableSumAmount(year, month, userId);

		Integer sumAmount = 0;
		if (depositSumAmount != 0 && spendingSumAmount != 0) {
			sumAmount = depositSumAmount - spendingSumAmount;
		} else if (depositSumAmount != 0 && spendingSumAmount == 0) {
			sumAmount = depositSumAmount;
		} else if (depositSumAmount == 0 && spendingSumAmount != 0) {
			sumAmount = spendingSumAmount;
		}
		return sumAmount;
	}
	**/
}
