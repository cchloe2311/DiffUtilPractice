## DiffUtil
> RecyclerView Support Library에 포함된 utility class. 두 리스크를 비교해 업데이트 되어야 할 목록을 반환해 줘 RecyclerView Adapter에 리스트 업데이트를 알리는 데 사용됨

### Why
리스트 아이템이 바뀌어 이를 RecyclerView에 알려야 하는 상황에서 다음 두 방법을 가장 많이 사용
**notifyDataSetChanged() 사용**
- 리스트 내 실제 변화를 알지 못하고 모든 아이템이 바뀌었다고 생각
- 따라서, RecyclerView는 모든 뷰를 다시 생성 -> very expansive

**Adapter의 인스턴스를 새로 생성**
-> notifyDataSetChanged() 사용 시 보다 더 큰 리소스와 시간 필요 -> even worse
### How
- Eugene W. Myers’s의 차이 알고리즘을 이용
- getChangePayload() 에서 업데이트가 필요한 아이템 정보를 리턴
- notifyItemMoved()
notifyItemRangeChanged()
notifyItemRangeInserted()
notifyItemRangeRemoved()
와 같은 RecyclerView Adapter의 메소드 호출
- 결론적으로 onBindViewHolder(… List payloads) 메서드가 호출되어 목록이 업데이트

즉, 정말 업데이트가 필요한 아이템에 대해서만 업데이트 진행 !

사용예제는 각 브랜치에서 확인할 수 있습니다
- main: notifyDataSetChanged() 사용
- DiffUtil_Callback: DiffUtil.Callback 재정의 및 사용
- AsyncListDiffer
- ListAdapter

관련 velog 글
[DiffUtil - velog.io/@cchloe2311](https://velog.io/@cchloe2311/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-DiffUtil)
