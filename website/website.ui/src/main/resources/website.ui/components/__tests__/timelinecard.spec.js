import TimelineCard from '@/components/TimelineCard'
import { shallowMount } from '@vue/test-utils'

describe('TimelineCard.vue', () => {
  it('validate content', () => {
    const wrapper = shallowMount(TimelineCard, {
      propsData: {
        card: {
          title: 'One of my tasks',
          year: 2020
        }
      }
    })
    expect(wrapper.html()).toContain('One of my tasks')
    expect(wrapper.html()).toContain(2020)
  })
})
