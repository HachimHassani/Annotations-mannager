/* This example requires Tailwind CSS v2.0+ */
import { StarIcon } from '@heroicons/react/solid'
import {TokenAnnotator, TextAnnotator} from 'react-text-annotate'
import React from 'react'
import Navbar from './navbar'
import Sidebar from './sidebar'

const reviews = [
  {
    id: 1,
    title: "Can't say enough good things",
    rating: 5,
    content: `I was really pleased with the overall shopping experience. My order even included a little personal, handwritten note, which delighted me!The product quality is amazing, it looks and feel even better than I had anticipated. Brilliant stuff! I would gladly recommend this store to my friends. And, now that I think of it... I actually have, many times!`,
    author: 'Risako M',
    date: 'May 16, 2021',
    datetime: '2021-01-06',
  },

  // More reviews...
]
const Text = JSON.stringify(reviews.map((review) => review.content)).slice(2,-2)
console.log(JSON.stringify(Text).slice(2,-2));
const TEXT = `On Monday night , Mr. Fallon will have a co-host for the first time : The rapper Cardi B , who just released her first album, " Invasion of Privacy . "`
console.log(typeof(TEXT));

const TAG_COLORS = {
    Chemical: '#00ffa2',
    Disease: '#84d2ff',
  }

function classNames(...classes) {
  return classes.filter(Boolean).join(' ')
}

class Annot extends React.Component{
    state = {
        value: [],
        tag: 'Chemical',
      }
    
      handleChange = value => {
        this.setState({value})
      }
    
      handleTagChange = e => {
        this.setState({tag: e.target.value})
      }
render(){
  return (
    <><Navbar></Navbar><Sidebar></Sidebar><div className="bg-white">

      <div className="max-w-2xl mx-auto py-16 px-4 sm:py-24 sm:px-6 lg:max-w-7xl lg:px-8 " style={{ marginTop: -90 }}>

        <div className="mt-6 pb-10 border-t border-b border-gray-200 divide-y divide-gray-200 space-y-10">

          {reviews.map((review) => (
            <div key={review.id} className="pt-10 lg:grid lg:grid-cols-12 lg:gap-x-8">
              <div className="lg:col-start-5 lg:col-span-8 xl:col-start-4 xl:col-span-9 xl:grid xl:grid-cols-3 xl:gap-x-8 xl:items-start">


                <div className="mt-4 lg:mt-6 xl:mt-0 xl:col-span-2">

                  <select style={{ marginLeft: -4 }} className="mt-3 space-y-6 text-sm text-black-500" onChange={this.handleTagChange} value={this.state.tag}>
                    <option value="Chemical">Chemical</option>
                    <option value="Disease">Disease</option>
                  </select>
                  <br /><br />
                  <h5 className="text-sm font-medium text-gray-900">{review.title}</h5>

                  <TokenAnnotator
                    className="mt-3 space-y-6 text-sm text-black-500"

                    tokens={Text.split(' ')}
                    value={this.state.value}
                    onChange={this.handleChange}
                    getSpan={span => ({
                      ...span,
                      tag: this.state.tag,
                      color: TAG_COLORS[this.state.tag],
                    })} />
                </div>
              </div>


            </div>
          ))}
        </div>
      </div>
    </div></>
  )
          }
}

export default Annot;