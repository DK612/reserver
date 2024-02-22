<template>

    <v-card outlined>
        <v-card-title>
            ReservationList # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="UserName" v-model="item.userName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="LodgingId" v-model="item.lodgingId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="StartDt" v-model="item.startDt" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="EndDt" v-model="item.endDt" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Boolean label="IsChecked" v-model="item.isChecked" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="PricePerDay" v-model="item.pricePerDay" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'ReservationListViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/reservationLists/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

