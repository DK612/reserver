<template>

    <v-card outlined>
        <v-card-title>
            PaymentList # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Number label="UserId" v-model="item.userId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="ReservationId" v-model="item.reservationId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Amount" v-model="item.amount" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="PayDt" v-model="item.payDt" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="RefundDt" v-model="item.refundDt" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'PaymentListViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/paymentLists/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

