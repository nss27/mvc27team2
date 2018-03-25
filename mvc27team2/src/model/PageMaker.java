package model;

public class PageMaker {
	private int totalCount; /* 전체 리스트 카운트값 */
	private int startRow; /* 페이지내 첫 게시글 */
	private int cutRow; /* 화면에 보여줄 리스트 갯수 */
	private int totalPage; /* 리스트 전체 페이지 */
	private int totalCurrentPage; /* 전체 리스트내 현재 페이지 넘버 */
	private int currentPageBlock; /* 현재 페이지 블록 넘버 */
	private int lastPageBlock; /* 마지막 페이지 블록 넘버 */
	private int startPage; /* 현재 페이지 블록내 시작 페이지넘버 */
	private int endPage; /* 현재 페이지 블록내 마지막 페이지넘버*/
	
	public PageMaker(int totalCount,int cutRow,int totalCurrentPage) {
		setTotalCount(totalCount);
		setCutRow(cutRow);
		setTotalCurrentPage(totalCurrentPage);
		setTotalPage();
		setStartRow();
		setCurrentPageBlock();
		setLastPageBlock();
		setStartPage();
		setEndPage();
	}
	
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage() {
		this.totalPage =  totalCount / cutRow;
		if((totalCount % cutRow) > 0) {
			this.totalPage++;
		}
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow() {
		this.startRow = (totalCurrentPage-1)*cutRow;
	}

	public int getCutRow() {
		return cutRow;
	}

	public void setCutRow(int cutRow) {
		this.cutRow = cutRow;
	}

	public int getTotalCurrentPage() {
		return totalCurrentPage;
	}

	public void setTotalCurrentPage(int totalCurrentPage) {
		this.totalCurrentPage = totalCurrentPage;
	}

	public int getCurrentPageBlock() {
		return currentPageBlock;
	}

	public void setCurrentPageBlock() {
		/*
		 * 1block내 3page만 보이게 했으니 현재 page번호롤 구한다
		 * block = 현재 page번호 / 3page만
		 * 1page는 block? = 1 / 3 = 0.3 몫: 0, 나머지: 3이므로 1block내 들어간다
		 * 3page는 block? = 3 / 3 = 1 몫: 1, 나머지: 0이므로 1block내 들어간다
		 * 7page는 block? = 7 / 3 = 2.33... 몫: 2, 나머지: 0.33...이므로 3block내 들어간다
		 */
		this.currentPageBlock = totalCurrentPage / 3;
		if((totalCurrentPage % 3) > 0) {
			this.currentPageBlock++;
		}
	}

	public int getLastPageBlock() {
		return lastPageBlock;
	}

	public void setLastPageBlock() {
		/*
		 * 33/5 = 6.6 -> 7page
		 * 7/3 = 2.33.. -> 3block
		 */
		this.lastPageBlock = totalPage / 3;
		if((totalPage % 3) > 0) {
			this.lastPageBlock++;
		}
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage() {
		this.startPage = (currentPageBlock*3)-2;
		/*
		 * 1block(1,2,3)
		 * 2block(4,5,6)
		 * 3block(7)
		 */
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage() {
		if(lastPageBlock == currentPageBlock) {
			this.endPage = totalPage;
		}else {
			this.endPage = startPage+2;
		}
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startRow=" + startRow + ", cutRow=" + cutRow + ", totalPage="
				+ totalPage + ", totalCurrentPage=" + totalCurrentPage + ", currentPageBlock=" + currentPageBlock
				+ ", lastPageBlock=" + lastPageBlock + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
}
